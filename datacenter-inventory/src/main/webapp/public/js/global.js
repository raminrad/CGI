(function ($) {
	$(document).ready(function() {
		//evt.preventDefault();

		$('.login').on('click', function(evt) {
			evt.preventDefault();
			$('.login').hide();
			$('.main-menu').show();
		});

		$('.main-menu a').click(function(evt) {
			evt.preventDefault();
			navigate('.' + $(this).attr('dest'));
		});


		function navigate(navClass) {
			$('.container').hide();
			$(navClass).show();
		}
	});

})(jQuery);
