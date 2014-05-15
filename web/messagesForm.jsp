<div class="secao_miolo">
    
    
    <form id="theForm" method="POST" action="messages">
        <label for="message">Mensagem</label>
        <textarea rows="4" name="message" id="message"></textarea>
        <input type="text" id="limit" size="4" readonly="readonly">
        <input type="submit" value="Enviar mensagem">

        <s:fielderror></s:fielderror>
    </form>
</div>
            <script type="text/javascript">
var count = 255;
var limitEl = document.getElementById("limit");
var messageEl = document.getElementById("message");
function limiter(){
    var tex = messageEl.value;
    var len = tex.length;
    if(len > count){
            tex = tex.substring(0,count);
            messageEl.value = tex;
            return false;
    }
    limitEl.value = count-len;
}
messageEl.onkeyup = limiter;
limitEl.value = count;
</script>