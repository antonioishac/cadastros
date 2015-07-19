$(document).ready(function() {
	
	
	
//	$(function() {
		$("#inputUf").autocomplete({
//			dataType : "json",
			source:function(request,response){
				
				$.ajax({
					
					type:"GET",
					data:{term:$("#inputUf").val()},
					url : dominio + "/municipio/listaUf.do",

										
					success: function(data){ 
						
						if(typeof(data) === 'string'){
							
							data=JSON.parse(data);
							
							response($.map(data,function(campo){
								
								return{
									
									label:campo.nome,
									//value:campo.valor
								};
								
							}));
						}
						
						
					}
					
				});
				
			},
			select: function( event, ui ) {
				
				//alert(ui.item.label + " / " + ui.item.value );
				
				$("#inputUf").val(ui.item.label);
				
				return false;
			}
		});
	//});
});