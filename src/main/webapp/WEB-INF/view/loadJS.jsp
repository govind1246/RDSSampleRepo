<script>

    function loadJS(src, callback) {
        var s = document.createElement('script');
           s.src = src;
           s.async = true;
           s.onreadystatechange = s.onload = function() {
               var state = s.readyState;
               if (!callback.done && (!state || /loaded|complete/.test(state))) {
               callback.done = true;
               callback();
           }
        };
        document.getElementsByTagName('head')[0].appendChild(s);
    }
    
    loadJS('/js/jquery.js', function() { 
        P.register('jQuery');
    });

    P.when('jQuery').execute(function(){
        //	P.load.js("${path}/js/bootstrap.min.js");	
    });
</script>