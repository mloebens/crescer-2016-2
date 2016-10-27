//2A
console.log($('img[alt]'));

//2B
$('form > input[type="text"]').parent().addClass('template');

//2C
$('#myList .current')
	.removeClass('current')
	.next()
		.addClass('current');

//2D
$('#specials h2')
	.text('Promoções')
	.siblings('form')
		.find('[value="friday"]')
		.text('Dimitri');

//2E
$('#slideshow')
	.children()
		.first()
		.addClass('current')
		.siblings()
			.addClass('disabled');

