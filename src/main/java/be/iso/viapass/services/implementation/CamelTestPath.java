//package be.iso.viapass.services.implementation;
//
//import org.apache.camel.builder.RouteBuilder;
//
//public class CamelTestPath {
//
//        RouteBuilder builder = new RouteBuilder() {
//                public void configure() {
//                        errorHandler(deadLetterChannel("mock:error"));
//
//                        from("direct:a").to("direct:b");
//                }
//        };
//
//        public void findPathWithCamel() {
//
//        }
//}
