$(document).ready(() => {  

    $('#submit').click(() => {
      var username = $('#username').val();
      var password = $('#password').val();
  
      if (username === '' || password === '') {
        alert("Please enter username and password");
      } else {
        var data = {
          custid: username,
          pwd: password
        }
        console.log(data);
        var dataObject = JSON.stringify(data);
        console.log(dataObject);
  
        $.post({
          url: 'http://localhost:8080/auth/customer',
          data: dataObject,
          contentType: 'application/json'
        }).done(data => {
          window.localStorage.setItem("CustomerID", data.CustomerId);
          window.location.href = "index.html";
        }).fail(data => {
          console.log(data);
          alert(data.responseJSON.errorMessage);
        })
      }
    })
  
  });
  
  // let menu = document.querySelector('#menu-bars');
  // let navbar = document.querySelector('.navbar');
  
  // let section = document.querySelectorAll('section');
  // let navLinks = document.querySelectorAll('header .navbar a');
  
  // window.onscroll = () => {
  //   // menu.classList.remove('fa-times');
  //   navbar.classList.remove('active');
  //   section.forEach(sec => {
  //     let top = window.scrollY;
  //     let height = sec.offsetHeight;
  //     let offset = sec.offsetTop - 150;
  //     let id = sec.getAttribute('id');
  
  //     if (top => offset && top < offset + height) {
  //       navLinks.forEach(links => {
  //         links.classList.remove('active');
  //         document.querySelector('header .navbar a[href*=' + id + ']').classList.add('active');
  //       });
  //     };
  //   });
  // }
  
  