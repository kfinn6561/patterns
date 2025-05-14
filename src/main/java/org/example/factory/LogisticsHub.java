package org.example.factory;

import java.util.List;
import java.util.Optional;

public abstract class LogisticsHub {
    private List<Transport> transportPool = List.of();

    public LogisticsHub() {
    }

    public void deliverPackage(Location origin, Location destination) {
        Transport transport = getClosestAvailableTransport(origin);
        transport.deliver(origin, destination);
    }

    private Transport getClosestAvailableTransport(Location origin) {
        Optional<Transport> transportOptional =  transportPool.stream()
                .filter(transport -> !transport.isBusy())
                .min((t1, t2) -> Float.compare(
                        t1.getCurrentLocation().distanceTo(origin),
                        t2.getCurrentLocation().distanceTo(origin)));

        if (transportOptional.isPresent()) {
            return transportOptional.get();
        } else {
            System.out.println("No available transport found. Commissioning a new one");
            Transport newTransport = createTransport(origin);
            transportPool.add(newTransport);
            return newTransport;
        }
    }

    // This is the factory method
    protected abstract Transport createTransport(Location origin);
}
