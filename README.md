Старт Docker-   
docker compose up -d 

Добавить комнату-   
Invoke-RestMethod -Method POST -Uri "http://localhost:8080/api/admin/rooms" -ContentType "application/json" -Body '{"name":"Room A","roomClass":"STANDARD","price":1500,"description":"test room номер"}'   

Удалить комнату-   
Invoke-RestMethod -Method DELETE -Uri "http://localhost:8080/api/admin/rooms/id комнаты"

Просмотр комнат-  
http://localhost:8080/api/admin/rooms  
ИЛИ    
Invoke-RestMethod -Method GET -Uri "http://localhost:8080/rooms"

Бронь комнаты-  
Invoke-RestMethod -Method POST -Uri "http://localhost:8080/bookings" -ContentType "application/json" -Body '{"username":"user1","room":{"id":ID комнаты},"startDate":"2026-05-20","endDate":"2026-05-22"}'

Просмотр забронированных комнат  
http://localhost:8080/bookings 
ИЛИ    
Invoke-RestMethod -Method GET -Uri "http://localhost:8080/bookings"
