<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <style>
      @import url(
        https://fonts.googleapis.com/css?family=Josefin+Slab:100,
        200,
        400
      );
      @import url(
        https://fonts.googleapis.com/css?family=Lato:100,
        200,
        300,
        400
      );
      *,
      body,
      html {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      body {
        background-color: #222;
        color: #fff;
        font-family: "Lato", sans-serif;
      }
      .wrap {
        overflow: hidden;
      }
      h1,
      h3 {
        text-align: center;
      }
      .surprise {
        font-size: 2.5rem;
      }
      .surprise .centered {
        border: 3px dashed #efefef;
        padding: 30px 40px 40px;
      }
      .surprise p {
        font-size: 1rem;
        text-align: center;
        margin-top: 15px;
      }
      .centered {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
      }
      .toggle {
        position: relative;
        z-index: 90;
      }
      .deck {
        width: 100%;
        min-height: 100vh;
        position: absolute;
        top: 0;
        left: 0;
        z-index: 10;
        overflow: hidden;
      }
      .deck:before,
      .deck:after {
        content: "";
        width: 100%;
        height: 50%;
        position: absolute;
        left: 0;
        background: #eb1f48;
        transition: transform 1s ease;
      }
      .deck:before {
        top: 0;
      }
      .deck:after {
        bottom: 0;
      }
      .deck.is-over:before {
        -webkit-transform: translate3d(-100vw, 0, 0);
        transform: translate3d(-100vw, 0, 0);
      }
      .deck.is-over:after {
        -webkit-transform: translate3d(100vw, 0, 0);
        transform: translate3d(100vw, 0, 0);
      }
      .text {
        width: 5em;
        height: 3em;
        z-index: 20;
        font-size: 4rem;
        line-height: 1em;
        font-weight: 700;
        color: #fff;
      }
      .text:before,
      .text:after {
        content: attr(title);
        display: block;
        overflow: hidden;
        transition: transform 1s ease;
      }
      .text:before {
        height: 1.5em;
        position: relative;
        z-index: 20;
      }
      .is-over .text:before {
        -webkit-transform: translate3d(-100vw, 0, 0);
        transform: translate3d(-100vw, 0, 0);
      }
      .text:after {
        width: inherit;
        padding-bottom: 0.09em;
        position: absolute;
        top: 0;
        left: 0;
        z-index: 10;
        vertical-align: bottom;
        clip: rect(1.5em auto auto auto);
      }
      .is-over .text:after {
        -webkit-transform: translate3d(100vw, 0, 0);
        transform: translate3d(100vw, 0, 0);
      }
    </style>
  </head>
  <body>
    <!-- Pen content -->
    <div class="wrap">
      <div class="deck js-scene">
        <div class="text centered" title="How about you scroll down."></div>
      </div>
      <div class="surprise">
        <div class="centered">
          <h1>Tadaaaa!</h1>
          <h3>You discovered my secret lair.</h3>
          <p>(Scrolling up gets you outta here!)</p>
        </div>
      </div>
    </div>
    <!-- /content -->
  </body>
  <script>
    // Credits to Tiffan Rayside (@tmrDevelops) for
    // educating me about the touchmove event! ♥

    // TODO: debounce scroll event
    $(document).ready(function() {
      var $scene = $(".js-scene");

      $(window).on("mousewheel DOMMouseScroll touchmove", function(e) {
        var scrollingDown = (function() {
          var delta, compareEvent;

          if (e.type === "touchmove") {
            compareEvent = "touchmove";
          } else {
            compareEvent = "DOMMouseScroll";
          }

          delta =
            e.type === compareEvent
              ? e.originalEvent.detail * -40
              : e.originalEvent.wheelDelta;

          return delta > 0 ? 0 : 1;
        })();

        if (scrollingDown) {
          $scene.addClass("is-over");
        } else {
          $scene.removeClass("is-over");
        }
      });
    }); //doc.ready()
  </script>
</html>
