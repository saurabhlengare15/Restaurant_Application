$(document).ready(() => {

  // if (window.localStorage.getItem('AdminID') == null) {
  //   window.location.href = "./index.html";
  // }
  // else{
  //   window.location.href = "./addmenu.html";
  // }

  // if (window.localStorage.getItem('AdminID') == null) {
  //   $('#menu').hide();
  //   $('#order').hide();
  //   $('#logout').hide();
  //   $('#customer').hide();
  //   $('.logo').hide();
  // } else {
  //   $('#login').hide();
  // }

  // $('.logo').click(() => {
  //   window.location.href = "home.html";
  // })

  // $('#customer').click(() => {
  //   window.location.href = "customer.html";
  // })

  // $('#login').click(() => {
  //   window.location.href = "index.html";
  // })

  // $('#menu').click(() => {
  //   window.location.href = "addmenu.html";
  // })

  // $('#order').click(() => {
  //   window.location.href = "addorder.html";
  // })

  // $('#logout').click(() => {
  //   window.localStorage.clear();
  //   window.location.href = "http://127.0.0.1:5500/index.html";
  // });


  $('#submit').click(() => {
    var username = $('#username').val();
    var password = $('#password').val();

    if (username === '' || password === '') {
      alert("Please enter username and password");
    } else {
      var data = {
        adminid: username,
        pwd: password
      }
      console.log(data);
      var dataObject = JSON.stringify(data);
      console.log(dataObject);

      $.post({
        url: 'http://localhost:8080/auth/admin',
        data: dataObject,
        contentType: 'application/json'
      }).done(data => {
        window.localStorage.setItem("AdminID", data.AdminId);
        window.location.href = "home.html";
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

