<c:if test="${mensagem != null}">
	<div class="${mensagem.tipoMensagem.classeCss} centroCadastro" role="alert">
		
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
     		&times;
  		</button>
	
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		${mensagem.texto}
	
	</div>
</c:if>