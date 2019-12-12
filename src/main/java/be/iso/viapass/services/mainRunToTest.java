package be.iso.viapass.services;


import be.iso.viapass.services.implementation.hibernateTest;


public interface mainRunToTest {

        hibernateTest hibernateTest = new hibernateTest();

        static void mainRunToTestDB(){
                hibernateTest.connectDBInsert();
        }

}
