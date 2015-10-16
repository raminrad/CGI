(function ($) {
	$(document).ready(function() {
		//evt.preventDefault();

		$('.login').on('click', function(evt) {
			evt.preventDefault();
			$('.login').hide();
			$('.main-menu').show();
		});
	});

})(jQuery);
