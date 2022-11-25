# ***Library Application***

_______

###### ***Used technologies:***

<sub>-Spring Boot  
-Spring Web  
-Spring Data JDBC  
-H2 database  
-Modelmapper  
-Lombok</sub>
-------

#### LibraryController

###### Show printed productions list:

    [GET]localhost:8080/library/

###### Show printed production by id:

    [GET]localhost:8080/library/{id}

###### Add printed production:

    [POST]localhost:8080/library/

###### Delete printed production by id:

    [DEL]localhost:8080/library/{id}

###### Update printed production by id:

    [PUT]localhost:8080/library/{id}

_______

#### CatalogController

###### Filter with request params productions_type, author, publisher:

    [GET]localhost:8080/library/catalog/filter?type={type}&author={author}&publisher={publisher}
###### Filter by before or after date [input date format: "YYYY-MM-DD"]:

    [GET]localhost:8080/library/catalog/before?date={date}
    [GET]localhost:8080/library/catalog/after?date={date}
###### Common base search by keyword in object:

    [GET]localhost:8080/library/catalog/search?keyword={keyword}