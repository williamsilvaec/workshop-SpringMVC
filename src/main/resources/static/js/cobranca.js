/**
 * Created by william on 05/06/2017.
 */

$('#confirmacaoExclusaoModal').on('show.bs.modal', function (event) {

    var button = $(event.relatedTarget); // "pega" o botão que chamou o modal

    var codigoTitulo = button.data('codigo');
    var descricaoTitulo = button.data('descricao');

    var modal = $(this);
    var form = modal.find('form'); // seleciona o formulário do modal
    var action = form.data('url-base'); // seleciona o atributo url-base do formulário
    if (!action.endsWith('/')) {
        action += '/'; // adiciona '/' se não tiver
    }

    form.attr('action', action + codigoTitulo);

    modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>'+descricaoTitulo+'</strong>');
});

$(function(){

    $('[rel="tooltip"]').tooltip();
    $('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
    $('.js-atualizar-status').on('click', function (event) {

        event.preventDefault();

        var botaoReceber = $(event.currentTarget);
        var urlReceber = botaoReceber.attr('href');

        var resposta = $.ajax({
            url: urlReceber,
            type: 'PUT'
        });

        resposta.done(function (e) {
            var codigoTitulo = botaoReceber.data('codigo');
            $('[data-role='+codigoTitulo+']').html('<span class="label label-success">' + e + '</span>');
            botaoReceber.hide();
        });

        resposta.fail(function(e) {
            console.log(e);
        });

    });
});