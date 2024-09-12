spring.datasource.url=jdbc:postgresql://localhost:5432/stock_db
spring.datasource.username=postgres
spring.datasource.password=Admin
spring.jpa.hibernate.ddl-auto=update

#Penjelasan
-DTO digunakan agar data yang diterima dan dikirim lebih terstruktur.
-Log4j2 digunakan untuk logging ke file dan stdout.
-Validasi MIME type memastikan hanya file gambar dengan format tertentu yang diterima.
-JPA mempermudah operasi database seperti create, read, update, dan delete.
