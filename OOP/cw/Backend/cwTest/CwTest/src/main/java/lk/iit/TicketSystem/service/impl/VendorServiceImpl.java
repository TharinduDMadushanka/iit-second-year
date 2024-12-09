package lk.iit.TicketSystem.service.impl;

import lk.iit.TicketSystem.dto.ConfigurationDTO;
import lk.iit.TicketSystem.dto.VendorDTO;
import lk.iit.TicketSystem.entity.Vendor;
import lk.iit.TicketSystem.repo.TicketRepo;
import lk.iit.TicketSystem.repo.VendorRepo;
import lk.iit.TicketSystem.service.VendorService;
import lk.iit.TicketSystem.thread.VendorThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    @Autowired
    private ConfigurationDTO configurationDTO;

    @Autowired
    private TicketRepo ticketRepo;

    private final Map<Integer, Thread> activeVendorThreads = new ConcurrentHashMap<>();
    private final Map<Integer, VendorThread> vendorThreadInstances = new ConcurrentHashMap<>();

    @Override
    public String saveVendor(VendorDTO vendorDTO) {
        Vendor vendor = new Vendor(
                vendorDTO.getVendorId(),
                vendorDTO.getVendorName(),
                vendorDTO.getEmail(),
                vendorDTO.getReleaseInterval(),
                vendorDTO.getTicketType(),
                vendorDTO.getTicketPrice()
        );

        if (!vendorRepo.existsById(vendor.getVendorId())) {
            vendorRepo.save(vendor);
            return "Vendor added successfully";
        } else {
            return "Vendor already exists";
        }
    }

    @Override
    public String deleteVendor(int id) {
        if (!vendorRepo.existsById(id)) {
            return "Vendor not found";
        } else {
            stopVendorThread(id);
            vendorRepo.deleteById(id);
            return "Vendor deleted successfully";
        }
    }

    @Override
    public String startAllVendorThreads() {
        List<Vendor> vendors = vendorRepo.findAll();
        if (vendors.isEmpty()) {
            return "No vendors found to start threads";
        }

        for (Vendor vendor : vendors) {
            startVendorThread(vendor);
        }

        return "Started threads for " + vendors.size() + " vendors. Each vendor will release " +
                configurationDTO.getMaxTicketCapacity() + " tickets with " +
                configurationDTO.getTicketReleaseRate() + "ms interval";
    }

    private void startVendorThread(Vendor vendor) {
        stopVendorThread(vendor.getVendorId());

        VendorThread vendorThread = new VendorThread(
                vendor,
                ticketRepo,
                configurationDTO
        );

        Thread thread = new Thread(vendorThread, "VendorThread-" + vendor.getVendorId());
        thread.start();

        activeVendorThreads.put(vendor.getVendorId(), thread);
        vendorThreadInstances.put(vendor.getVendorId(), vendorThread);
    }

    @Override
    public String stopAllVendorThreads() {
        int stoppedThreads = 0;
        for (Integer vendorId : new ArrayList<>(activeVendorThreads.keySet())) {
            if (stopVendorThread(vendorId)) {
                stoppedThreads++;
            }
        }
        return "Stopped " + stoppedThreads + " vendor threads";
    }

    private boolean stopVendorThread(int vendorId) {
        VendorThread vendorThread = vendorThreadInstances.get(vendorId);
        Thread thread = activeVendorThreads.get(vendorId);

        if (vendorThread != null && thread != null) {
            vendorThread.stopThread();
            try {
                thread.join(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            activeVendorThreads.remove(vendorId);
            vendorThreadInstances.remove(vendorId);
            return true;
        }
        return false;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        List<Vendor> vendors = vendorRepo.findAll();
        List<VendorDTO> vendorDTOList = new ArrayList<>();

        if (!vendors.isEmpty()) {
            for (Vendor vendor : vendors) {
                vendorDTOList.add(new VendorDTO(
                        vendor.getVendorId(),
                        vendor.getVendorName(),
                        vendor.getEmail(),
                        vendor.getReleaseInterval(),
                        vendor.getTicketType(),
                        vendor.getTicketPrice()
                ));
            }
            return vendorDTOList;
        } else {
            throw new RuntimeException("No Vendor found");
        }
    }

    @Override
    public String updateVendor(VendorDTO vendorDTO) {
        boolean existsVendor = vendorRepo.existsById(vendorDTO.getVendorId());

        if (existsVendor) {
            Vendor vendor = vendorRepo.getReferenceById(vendorDTO.getVendorId());
            vendor.setVendorName(vendorDTO.getVendorName());
            vendor.setEmail(vendorDTO.getEmail());
            vendor.setReleaseInterval(vendorDTO.getReleaseInterval());
            vendor.setTicketType(vendorDTO.getTicketType());
            vendor.setTicketPrice(vendorDTO.getTicketPrice());
            vendorRepo.save(vendor);
            return "Vendor updated successfully";
        } else {
            return "Vendor not found";
        }
    }
}