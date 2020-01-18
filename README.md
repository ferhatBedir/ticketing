# ticketing

Uygulamada kullanılan Teknolojıler
* Java 8
* SpringBoot
* Gradle
* MsSql
* Lombook
* Hibernate
* Swagger

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
* Uygulamada airlineCompany, airport, route, flying ve ticket tabloları bulunmaktadır. Bu tabloların entity kısımlarında propertyleri notNull olarak tanımlanmıştır.
* Uygulamada herhangi bir tabloya kayıt eklemek için, http Post isteği yapılmalıdır.
* Post body object'leri uygulamadaki DTO class'larıdır. Bu classlar içerisinde @NotNull olarak tanımlanan bir parametre istek içerinde gönderilmesi zorunludur. Kalanları ise opsiyoneldir.
* Bu uygulamayı local ortamda ayağa kaldırdıktan sonra http://localhost:9090/swagger-ui.html#/RouteController_API addresinden uygulama dokumanına erişebilirsiniz.(Uygulama default 9090 portunca çalışmaktadır. bu config değiştirildiğinde swagger adresinide değiştirmeyi unutmayınız.)
