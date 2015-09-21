$(document).ready(function() {
	
	$('#cadastraNcm').addClass('active');
			
	$('#ncmForm').submit(function (e) {
		
		if ($('#inputCodigo').val() != '' && $('#inputDescricao').val() != '') {
			
			e.preventDefault();
			
			var formdata = $('#ncmForm').serialize();
			
			$.ajax({
				type: "POST", 
				url: dominio + '/ncm/salvarNcm.do', 
				data: formdata,
				success: function(e){
								
					LimparCampos("#divCadastro");
					$('#mensagem').html(e);				
					
				}, error: function (er) {
					alert('Erro: ' + er);
				} 
			});			
			
		}					
	});
	
	$('#ncmForm').validate({

		rules: {
			codigo: {
				required: true,
				minlength: 2				
			},
			descricao: {
				required: true,
				minlength: 2
			}
		},
		messages: {

			codigo:{
				required: 'Campo código obrigatório',
				minlength: 'Tamannho mínimo 2 caracteres'					
			},
			descricao: {
				required: 'Campo descrição obrigatório',
				minlength: 'Tamannho mínimo 2 caracteres'
			}
		},
		highlight: function(element) {
            $(element).closest('.row').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.row').removeClass('has-error');
        },				        
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('input').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }						
	});

	function LimparCampos(container) {
	    $(container).find(":input, select").each(function () {
	        switch (this.type) {
	            case "file":
	            case "password":
	            case "text":
	            case "textarea":
	                $(this).val("");
	                break;
	            case "checkbox":
	            case "radio":
	                this.checked = false;
	        }

	        $(this).children("option:selected").removeAttr("selected").end()
	               .children("option:first").attr("selected", "selected");
	    });
	}
	
});