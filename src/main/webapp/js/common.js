$(document).ready(function () {

    //Таймер обратного отсчета
    //Документация: http://keith-wood.name/countdown.html
    //<div class="countdown" date-time="2015-01-07"></div>
    var austDay = new Date($(".countdown").attr("date-time"));
    $(".countdown").countdown({until: austDay, format: 'yowdHMS'});

    //Попап менеджер FancyBox
    //Документация: http://fancybox.net/howto
    //<a class="fancybox"><img src="image.jpg" /></a>
    //<a class="fancybox" data-fancybox-group="group"><img src="image.jpg" /></a>
    $(".fancybox").fancybox();

    //Навигация по Landing Page
    //$(".top_mnu") - это верхняя панель со ссылками.
    //Ссылки вида <a href="#contacts">Контакты</a>
    $(".top_mnu").navigation();

    //Добавляет классы дочерним блокам .block для анимации
    //Документация: http://imakewebthings.com/jquery-waypoints/
    $(".block").waypoint(function (direction) {
        if (direction === "down") {
            $(".class").addClass("active");
        } else if (direction === "up") {
            $(".class").removeClass("deactive");
        }
        ;
    }, {offset: 100});

    //Плавный скролл до блока .div по клику на .scroll
    //Документация: https://github.com/flesler/jquery.scrollTo
    $("a.scroll").click(function () {
        $.scrollTo($(".div"), 800, {
            offset: -90
        });
    });

    //Каруселька
    //Документация: http://owlgraphic.com/owlcarousel/
    var owl = $(".carousel");
    owl.owlCarousel({
        items: 4
    });
    owl.on("mousewheel", ".owl-wrapper", function (e) {
        if (e.deltaY > 0) {
            owl.trigger("owl.prev");
        } else {
            owl.trigger("owl.next");
        }
        e.preventDefault();
    });
    $(".next_button").click(function () {
        owl.trigger("owl.next");
    });
    $(".prev_button").click(function () {
        owl.trigger("owl.prev");
    });

    //Кнопка "Наверх"
    //Документация:
    //http://api.jquery.com/scrolltop/
    //http://api.jquery.com/animate/
    $("#top").click(function () {
        $("body, html").animate({
            scrollTop: 0
        }, 800);
        return false;
    });

    //Аякс отправка форм
    //Документация: http://api.jquery.com/jquery.ajax/
    $("form").submit(function () {
        $.ajax({
            type: "GET",
            url: "/lol",
            data: $("form").serialize()
        }).done(function () {
            alert(response().toString);
            setTimeout(function () {
                $.fancybox.close();
            }, 1000);
        });
        return false;
    });


    $(document).ready(function () {

        $("#owl-example").owlCarousel();

    });

    $("#owl-demo").owlCarousel({

        autoPlay: 3000, //Set AutoPlay to 3 seconds

        items: 4,
        itemsDesktop: [1199, 3],
        itemsDesktopSmall: [979, 3]

    });

});

var main = {
    registration: function () {
        var mail = document.getElementById("email_for_reg").value;
        var pass1 = document.getElementById("password_for_reg").value;
        var pass2 = document.getElementById("password_for_reg_again").value;
        var pass;
        if (pass1 == pass2) pass = pass1;
        else {
            alert('введенные пароли не совпадают');
            document.getElementById("password_for_reg").value = '';
            document.getElementById("password_for_reg_again").value = '';
        }
        $.ajax({
            type: "POST",
            url: "/lol",
            dataType: "json",
            data: {requestType: "registration", password: pass, email: mail},
            success: function (data) {
                
                main.setcookie(data.value);
                $('#myModal1').modal('hide');
                $('#user_login_block').hide();
                $('#user_name').show();
                $('#user_name').text(mail);
            }
        });

    },

    log_in: function () {
        alert('here login');
        var log = document.getElementById("email").value;
        var pass = document.getElementById("password").value;
        $.ajax({
            type: "POST",
            url: "/lol",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},
            success: function (data) {
                console.log(data.resp);
                $('#myModal').modal('hide');
                $('#user_login_block').hide();
            }
        });
    }
    ,

    log_out: function () {
        $('#user_login_block').show();
        $('#user_name').hide();
        main.deletecookie();
    }
    ,

    diseaseRequest: function () {
        var symptom1 = document.getElementById("symptom1").value;
        var symptom2 = document.getElementById("symptom2").value;
        var symptom3 = document.getElementById("symptom3").value;
        var symptom4 = document.getElementById("symptom4").value;
        var symptom5 = document.getElementById("symptom5").value;
        $.ajax({
            type: "POST",
            url: "/lol",
            dataType: "json",
            data: {
                requestType: "diseaserequest",
                symptom1: symptom1,
                symptom2: symptom2,
                symptom3: symptom3,
                symptom4: symptom4,
                symptom5: symptom5,
            },
            success: function (data) {
                document.getElementById("resp").value = data.resp;
                console.log(data.requestProcessingTime);
            }
        });
    },
    setcookie: function (value) {
        document.cookie = value;
    },
    deletecookie: function deleteCookie(name) {
    setCookie(name, "", {
        expires: -1
    })
}

};

