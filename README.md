# JavaCamp

Bu repo eğitim reposudur.
SOLİD prensiplerine uygun ve N-Tier mimariye göre tasarlanmıştır.

# northwind

###  a) entity Katmanı

* ##### Projenin veritabanını oluşturacak tabloların classlarının tasarlandığı ve ilişkilerin oluşturulduğu katmandır.

* ##### Lombok, set-get metotları ve constructor yapılarının oluşturulması için kullanıldı.
 
###  b) dataAccess Katmanı
* ##### Veritabanına erişimi sağlamak için JPA Repository in  imlement edildiği ve sorgu imzalarının hazırlandığı "interface" lerden oluşmaktadır. 
###  c) bussines Katmanı
* #### Oprerasyonlarımızı yönettiğimiz katmanı temsil eder. 
*       bussiness/absracts da operasyonların imzaları tanımlanır.
*       bussines/concretes da operasyonların clasları tanımlanır.
###  d) core Katmanı
* #### Her projede kullanabileceğimiz yapıları bu katmanda yazılmaktadır.
* #### Result, Logging, Mappers ve User yapıları bu katmanda gerçekleştirildi.
###  e) api Katmanı
* #### Çalıştırmak istediğimiz sorguların çağrılarının yapıldı katmandır"

 ---Collections lar oluşturuldu ve repoya eklendi.---