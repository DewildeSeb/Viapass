package be.iso.viapass.services.implementation;

import be.iso.viapass.repository.WLBL;
import be.iso.viapass.repository.WLBLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class hibernateTest {

        @Autowired
        WLBLRepository wlblRepository;

        public void connectDBInsert() {
                WLBL wlbl = new WLBL();
                WLBL wlblResult;
                wlbl.setExceptionListType(5);
                wlbl.setExceptionListVersion(25);
                wlbl.setReceiverCountryCode("testtest");
                wlbl.setProcessing(true);
                wlbl.setTimestampRequest(LocalDateTime.now());

                wlblResult = wlblRepository.save(wlbl);
                System.out.println(wlblResult);
        }
}
