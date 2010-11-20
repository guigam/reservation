<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://code.google.com/p/gmaps4jsf/" prefix="m" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<f:view>

    <head>
    <title>Welcome to GMaps4JSF</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

    <m:resources key="ABQIAAAA3yJ5iAFn4zDifNFLnZjZqBTlnsQ1gFKWE5O385MHkvYiHcSUVhRgkSkj4c4qtQSDzU9MFe7SWGwuIg"/>
    </head>

	<body onunload="GUnload()">
    	<h:form id="form">
    		<m:map width="500px" height="500px" latitude="30.01" longitude="31.14">
    			<m:marker latitude="30.01" longitude="31.14"/>
    			<m:htmlInformationWindow latitude="30.01" longitude="31.14"
    			   htmlText="<center>Welcome to Cairo, Egypt<br><img height=30 width=50 src=http://www.appliedlanguage.com/flags_of_the_world/large_flag_of_egypt.gif></center>"/>
    		</m:map>
    	</h:form>
	
    </body>
	</f:view>
</html>
