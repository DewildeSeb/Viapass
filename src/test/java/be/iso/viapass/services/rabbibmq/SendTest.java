package be.iso.viapass.services.rabbibmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class SendTest {

        @TestConfiguration
        static class SendTestContextConfiguration {
                @Bean
                public Send send(){
                        return new Send();
                }
        }

        @Autowired
        private Send send;

        @Test
        void sendRequest() throws Exception {

        }
}