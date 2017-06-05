/**
 * Created by william on 05/06/2017.
 */

$('#confirmacaoExclusaoModal').on('show.bs.modal', function (event) {

    var button = $(event.relatedTarget); // "pega" o botão que chamou o modal

    var codigoTitulo = button.data('codigo');
    var descricaoTitulo = button.data('descricao');

    var modal = $(this);
    var form = modal.find('form'); // seleciona o formulário do modal
    var action = form.attr('action'); // seleciona o atributo action do formulário
    if (!action.endsWith('/')) {
        action += '/'; // adiciona '/' se não tiver
    }

    form.attr('action', action + codigoTitulo);

    modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>'+descricaoTitulo+'</strong>');
});
