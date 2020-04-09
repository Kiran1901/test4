$(document).ready(function() {
  $("#password_mismatch").hide();
  $("#email_err").hide();
  $("#pass_len_err").hide();
  $("#name_err").hide();
  $("#submit").click(function() {
  var name = $("#name").val();
  var email = $("#email").val();
  var pass = $("#password").val();
  var cpass = $("#conf_password").val();

  if (!(name.match(name_pattern)) || name == null) {
    alert("invalid value in Name");
    return false;
  } else if (!(email.match(email_pattern)) || email == null) {
    alert("invalid value in Email");
    return false;
  } else if (pass == null || pass.length < 6) {
    alert("Password length must be >6");
    return false;
  } else if (cpass != pass) {
    alert("Confirm Password doesn't match with Password");
    return false;
  } else {
    return true;
  }
});

  var name_pattern = /^[A-Za-z]+$/;
  var email_pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  $("#name").change(function() {
    var name = $("#name").val();
    if (!(name.match(name_pattern))) {
      $("#name_err").show();
      return false;
    } else {
      $("#name_err").hide();
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
  $("#conf_password").change(function() {
    var pass = $("#password").val();
    var cpass = $("#conf_password").val();
    if (cpass != pass) {
      $("#password_mismatch").show();
      return false;
    } else {
      $("#password_mismatch").hide();
      return true;
    }
  });

})