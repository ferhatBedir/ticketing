# ticketing

Uygulamada kullanılan Teknolojıler
* Java 8
* SpringBoot
* Gradle
* MsSql
* Lombook
* Hibernate

Not: Uygulamayı çalıştırmak için; uygulama içerisinde application.properties dosyasında bulunan Db bilgilerini kendi local Db'nizin bilgileri ile değiştiriniz. 

Local ortamınızda msSql yok ise aşağıdaki docker komutu ile kolayca indirebilirsiniz.


docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=yourPassword' -p 1433:1433 -d mcr.microsoft.com/mssql/server:2017-latest

 Sql scriptleri
 
 * AirlineCompany Tablosu
 
 CREATE TABLE tempdb.dbo.airline_company(
 
 ID bigint IDENTITY PRIMARY KEY,
 
 CREATE_DATE DATE NOT NULL,
 
 COMPANY_NAME nvarchar(255) NOT NULL,
 
 GENERAL_CENTER nvarchar(255) NOT NULL,
 
 EMPLOYEE_COUNT int NOT NULL
);

* Airport Tablosu
CREATE TABLE tempdb.dbo.airport(

 ID bigint IDENTITY PRIMARY KEY,
 
 CREATE_DATE DATE NOT NULL,
 
 AIRPORT_NAME nvarchar(255) NOT NULL,
 
 AIRPORT_LOCATION nvarchar(255) NOT NULL
);

* Route Tablosu
CREATE TABLE tempdb.dbo.route(

 ID bigint IDENTITY PRIMARY KEY,
 
 CREATE_DATE DATE NOT NULL,
 
 STARTING_PLACE_ID bigint NOT NULL,
 
 DESTINATION_ID bigint NOT NULL,
 
 AIRPLANE_SPEED int NOT NULL,
 
 AIRPLANE_HEIGHT int NOT NULL,
 
 DISTANCE int NOT NULL
);

* Flying Tablosu
CREATE TABLE tempdb.dbo.flying(

 ID bigint IDENTITY PRIMARY KEY,
 
 CREATE_DATE DATE NOT NULL,
 
 AIRLINE_COMPANY_ID bigint NOT NULL,
 
 BOARDING_TIME DATE NOT NULL,
 
 DESTINATION_TIME DATE NOT NULL,
 
 FLYING_ROUTE_ID bigint NOT NULL,
 
 PRICE float NOT NULL,
 
 QUOTA int NOT NULL,
 
 REMAINING_QUOTA int NOT NULL
);

* Ticket Tablosu
CREATE TABLE tempdb.dbo.ticket(

 ID bigint IDENTITY PRIMARY KEY,
 
 FLYING_ID bigint NOT NULL,
 
 TICKET_NUMBER nvarchar(255) NOT NULL,
 
 TICKET_BUY_DATE DATE NOT NULL,
 
 MONEY_PAID float NOT NULL
);

Uygulama Çalışması Hakkında
* User Tablosu içinde -> name, surname, birthDate propertyleri bulunmaktadır. Bu propertyler notNull olarak tanımlanmıştır.
* PhoneNumber Tablosu içinde -> phoneNumber, user propertyleri bulunmaktadır. Bu propertyler notNull olarak tanımlanmıştır.
* User ve phoneNumber tabloları arasında oneToMany şeklinde bir ilişki vardır.
* Uygulamaya user eklemek için userModel sınıfı, http Post isteğinin body'si olarak gönderilmelidir.
* userModel sınıfınfda phoneNumber dolu gönderilirse user bilgisi ile birlikte phone bilgiside DB'ye eklenecektir. göderilmez ise sadece user bilgisi DB'ye eklenecektir.
* Uygulamaya phoneNumber eklemek için phoneNumberModel sınıfı, http Post isteğinin body'si olarak gönderilmeli ve header'da userId gönderilnelidir.
* User ve phoneNumber bilgilerinin silinmesi için, gerekli id bilgileri get request'in header'inde gönderilmelidir.
* User ve phoneNumber'in ilgili kayıtlarını görmek için, gerekli id bilgileri get request'in header'inde gönderilmelidir.


Uygulamanın enpointleri ve body örnekleri

* User eklemek için -> http://localhost:8080/user/add

	* Request Body;
	
		{
			
			"birthDate" : "1994-04-12T00:00:00.000",
			
			"name" : "testName",
			
			"surname" : "testSurname",
			
			"phoneNumber" : "05331231212" //isteğe bağlı gönderilebilir.
			
		}
		

* User güncellemek için -> http://localhost:8080/user/update?id=1(userId)
	
	* Request Body;
	
		{
			
			"birthDate" : "1999-04-12T00:00:00.000",
			
			"name" : "updateName",
			
			"surname" : "updateSurname",
			
		}

* Tüm user kayıtlarını görüntülemek için -> http://localhost:8080/user/findAll

* İlgili user kaydını görüntülemek için -> http://localhost:8080/user/find?id=1(userId)

* İlgili user kaydını silmek için -> http://localhost:8080/user/delete?id=1(userId)


* PhoneNumber Eklemek için -> http://localhost:8080/phoneNumber/add?id=1(userId)
	
	* Request Body;
	
		{
		
			"phoneNumber" : "05331231212"
			
		}

* İlgili userın tüm kayıtlı telefon numaralarını bulmak için -> http://localhost:8080/phoneNumber/find?id=1(userId)

* İlgili phoneNumber kaydı silmek için -> http://localhost:8080/phoneNumber/delete?id=1(phoneNumberId)










