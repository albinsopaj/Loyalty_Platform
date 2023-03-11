<html lang="it">
<head>
    <meta charSet="UTF-8">
        <meta name="viwport" content="width-device-width, initial scale-1.0">
            <title>Progetto di progettazione di applicazioni web e mobili</title>
</head>
<body>
<div class="Prova">
    <h1>Prova vue js</h1>
    <hr>
        <div id="applicazione">
            <h1></h1>{{message}}
        </div>
</div>
</body>
<script>
    var app=new Vue({
    e1:'#applicazione',
    data:{
    message:'Prova'
}
    )}
</script>
</html>