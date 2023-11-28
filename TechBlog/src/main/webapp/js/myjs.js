
   function doLike(pid,uid){
	  console.log(pid + "," + uid)
	  const d = {
		  pid: pid, 
		  uid: uid,
		  operation: 'like'
	  } 
	  
	  $.ajax({
		  url: "LikeServlet",
		  data: d, 
		  success: function(data, textStatus, jqXHR){
			  console.log(data);
			  if(data.trim()=='true'){
				  let c = $(".like-counter").html();
				  c++;
				  $(".like-counter").html(c);
			  }
		  },
		  error: function(jqXHR, textStatus, errorThrown){
			  console.log(data);
		  }
	  })
  }

 
  
/* 
 function doLike(pid, uid){
    console.log(pid + "," + uid);
    const d = {
        pid: pid, 
        uid: uid,
        operation: 'like'
    };

    $.ajax({
        url: "LikeServlet",
        data: d, 
        dataType: "json", // Specify that the response should be treated as JSON
        success: function(data, textStatus, jqXHR){
            // Check if the 'data' object is valid JSON
            if (data) {
                console.log(data);
            } else {
                console.log("Received empty response from the server.");
            }
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log(data);
        }
    });
}
*/

  
/*
  function doLike(pid, uid){
    console.log(pid + "," + uid)
    const d = {
        pid: pid, 
        uid: uid,
        operation: 'like'
    } 
    
    $.ajax({
        url: "LikeServlet",
        data: d, 
        success: function(data, textStatus, jqXHR){
            try {
                const parsedData = JSON.parse(data);
                console.log(parsedData);
            } catch (e) {
                console.log("Error parsing JSON: " + e);
            }
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log("Error: " + errorThrown);
        }
    })
}
*/


/*
  function doLike(pid, uid){
    console.log(pid + "," + uid);
    const d = {
        pid: pid, 
        uid: uid,
        operation: 'like'
    };

    fetch("LikeServlet", {
        method: 'POST', // or 'GET' depending on your server setup
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(d)
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error("Error:", error));
}
*/

