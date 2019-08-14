jQuery(document).ready(function () {
    $(function () {
        getAllMenu();
        getNavAriticle();
        getSideArticle();
    });

    function getAllMenu() {
        $.ajax("menu", {
            "type": "get",
        }).done(changeMenu);
    }

    function changeMenu(data) {
        $("#topMenu").html("");
        var ul = $("#topMenu");
        for (var i = 0; i < data.length; i++) {
            ul.append($("<li>").html("<a href='aCategory?id=" + data[i].id + "' > " + data[i].name + " </a>"));
        }
        $("#topMenu").append(ul);
    }

    function getNavAriticle() {
        $.ajax("articleScroll", {
            "type": "get",
        }).done(changeScrollArticle);
    }

    function changeScrollArticle(data) {
        $("ul#ticker01").html("");
        for (var i = 0; i < data.length; i++) {
            $("ul#ticker01").append($("<li>").html("<a href='frontarticle?id=" + data[i].id + "' ><img src='" + data[i].mainImage + "'> " + data[i].title + " </a>"));
        }
    }

    function getSideArticle() {
        $.ajax("articleScroll", {
            "type": "post",
        }).done(changeSideArticle);
    }

    function changeSideArticle(data) {
        $(".latest_postnav").html("");
        for (var i = 0; i < data.length; i++) {
            $(".latest_postnav").append("<li style='margin-top: 0px;'> <div class='media'> <a href='frontarticle?id=" + data[i].id + "' class='media-left'> <img  src='" + data[i].mainImage + "'> </a> <div class='media-body'> <a href='frontarticle?id=" + data[i].id + "' class='catg_title'> " + data[i].title + "</a> </div> </div> </li>");
        }
    }

    // for hover dropdown menu
    $('ul.nav li.dropdown').hover(function () {
        $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(200);
    }, function () {
        $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(200);
    });
    // slick slider call 
    $('.slick_slider').slick({
        dots: true,
        infinite: true,
        speed: 800,
        slidesToShow: 1,
        slide: 'div',
        autoplay: true,
        autoplaySpeed: 5000,
        cssEase: 'linear'
    });
    // latest post slider call 
    $('.latest_postnav').newsTicker({
        row_height: 64,
        speed: 800,
        prevButton: $('#prev-button'),
        nextButton: $('#next-button')
    });
    jQuery(".fancybox-buttons").fancybox({
        prevEffect: 'none',
        nextEffect: 'none',
        closeBtn: true,
        helpers: {
            title: {
                type: 'inside'
            },
            buttons: {}
        }
    });
    // jQuery('a.gallery').colorbox();
    //Check to see if the window is top if not then display button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.scrollToTop').fadeIn();
        } else {
            $('.scrollToTop').fadeOut();
        }
    });
    //Click event to scroll to top
    $('.scrollToTop').click(function () {
        $('html, body').animate({
            scrollTop: 0
        }, 800);
        return false;
    });
    $('.tootlip').tooltip();
    $("ul#ticker01").liScroll();
});

wow = new WOW({
    animateClass: 'animated',
    offset: 100
});
wow.init();

jQuery(window).load(function () { // makes sure the whole site is loaded
    $('#status').fadeOut(); // will first fade out the loading animation
    $('#preloader').delay(100).fadeOut('slow'); // will fade out the white DIV that covers the website.
    $('body').delay(100).css({
        'overflow': 'visible'
    });
})