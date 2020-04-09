$(document).ready(function() {
	$("#email_err").hide();
    $("#pass_len_err").hide();
    
    var email_pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        	
	$("#submit").click(function() {
		  var email = $("#email").val();
		  var pass = $("#password").val();

		  if (!(email.match(email_pattern)) || email == null) {
		    alert("invalid value in Email");
		    return false;
		  } else if (pass == null || pass.length < 6) {
		    alert("Password length must be >6");
		    return false;
		  } else {
		    return true;
		  }
		});
	
    $("#email").change(function() {
      var email = $("#email").val();
      if (!(email.match(email_pattern))) {
        $("#email_err").show();
        return false;
      } else {
        $("#email_err").hide();
        return true;
      }
    });
    $("#password").change(function() {
        var pass = $("#password").val();
        if (pass.length < 6) {
          $("#pass_len_err").show();
          return false;
        } else {
          $("#pass_len_err").hide();
          return true;
        }
      });
    })