package be.iso.viapass.repository;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * A wlbl entity.
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name = "viapass_list_operation")
public class WLBL {

        @TableGenerator(name = "wlblGen", pkColumnValue = "viapass_list_operation")
        @Id
        @GeneratedValue(strategy = GenerationType.TABLE, generator = "wlblGen")
        private long id;

        @Column(name = "msg_identifier")
        private Integer msgIdentifier;

        @Column(name = "sender_identifier")
        private Integer senderIdentifier;

        @Column(name = "sender_country_code")
        private String senderCountryCode;

        @Column(name = "receiver_identifier")
        private Integer receiverIdentifier;

        @Column(name = "exception_list_version")
        private Integer exceptionListVersion;

        @Column(name = "exception_list_type")
        private Integer exceptionListType;

        @Column(name = "receiver_country_code")
        private String receiverCountryCode;

        @Column(name = "xer_data_request")
        private LocalDateTime xerDataRequest;

        @Column(name = "timestamp_response")
        private LocalDateTime timestampResponse;

        @Column(name = "validate_request")
        private Boolean validateRequest;

        @Column(name = "has_next")
        private Boolean hasNext;

        @Column(name = "processing")
        private Boolean processing;

        @Column(name = "xer_data_response")
        private String xerDataResponse;

        @Column(name = "validate_response")
        private Boolean validateResponse;

        @Column(name = "timestamp_request")
        private LocalDateTime timestampRequest;
}