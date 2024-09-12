package com.stock.stock;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;  // Id Barang

    private String itemName;  // Nama Barang

    private Integer stockQuantity;  // Jumlah Stok Barang

    private String serialNumber;  // Nomor Seri Barang

    @Column(columnDefinition = "jsonb")
    private String additionalInfo;  // Additional Info (JSONB)

    private String imagePath;  // Gambar Barang (Path to the file)

    private LocalDateTime createdAt;  // Created At

    private String createdBy;  // Created By

    private LocalDateTime updatedAt;  // Updated At

    private String updatedBy;  // Updated By

}
