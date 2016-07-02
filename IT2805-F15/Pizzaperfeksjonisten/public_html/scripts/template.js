/* This file is fairly convoluted, so I've commented it heavily */
$(document).ready(function(){ // when the document is ready
    $("header").load("../pages/part/header.part", function() { // loads up header, callback function after the load
        var cur = window.location.href; // saving current url in variable
        var els = document.getElementsByTagName("nav")[0].getElementsByTagName("a"); // array of nav buttons
        for (var i = 0, length = els.length; i < length; i++) { // iterate through nav buttons
            var el = els[i];
            if (el.href == cur) { // if the current button corresponds to this url
                el.className += " thispage"; // add thispage as class, CSS does the rest
            }
        } 
        /* fixedNavbar.js is now here, as part of the template. works well for calling it on page load, when the header is ready */ 
        $(document).scroll(function() { // on scroll
            if ($(this).scrollTop() > 80) { // if scrolled past top of nav
                $("nav:first").css("position","fixed"); // nav is now fixed
                $("nav:first").css("top","0"); // place navbar at top of page
            } 
            else { // if scrolled up past top of nav
                $("nav:first").css("position","static"); // set back to static
            }
        });
        $(document).scroll(); // call the function, in case you refreshed while scrolled down the page
    });
    $("footer").load("../pages/part/footer.part"); // loads up footer
});