## 3 layer
+ presentation :
	* model : beans
	* views: jsp
	* controler : servlet 
+ Logic part : service pack (eg: check getIntance== true => cant create, before update=> get infor )
+ Dao: connect database and return object. 

## other Utilities
+ mapper : map SQL to object 
+ utils:
	* Session: memorize user infor
	* Http: Get object from API
	* Form: convert parameter in URL to object 
	* Message: config show alert , measage, 
+ filter : check session => permission

## Log error 
+ memory leak by garbage (remove connector in maven when publish ): ignore or put connector in lib 

## Note some function
+ PrepareStatement : has parameter != statement .
+ setAutoCommit : sync : del, insert, update. NOT select.
+ Stringbuilder : string can change.
+ resp.getParameter : return string only 
+ setPrameter() in Dao : set ? for query 
+ bean.xml : config init object for project 
+ resourceBundle: get some properties in main/resource/

## Login 
+ using filter, session 

## sitemesh 
+ goto site : by servlet=> filer
+ filter when html send to user=> sitemesh

## Show Content flow 
![image info](./ex.png)

## 
+ update, addNew (cause by jquery)


