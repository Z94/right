$(document).ready(function () { 
			$('.easyui-accordion li a').click(function(){
				var subtitle=$(this).text();
				var url = $(this).next().text();
				addTab(subtitle, url);
				$('.easyui-accordion li div').removeClass("selected"); 
				$(this).parent().addClass("selected"); 
			}).hover(function () { 
				$(this).parent().addClass("hover"); 
			}, function () { 
				$(this).parent().removeClass("hover"); 
			});
		
			function addTab(subtitle, url) {
				if (!$('#tabs').tabs('exists', subtitle)) { 
					$('#tabs').tabs('add', { 
						title: subtitle, 
						content: createFrame(url), 
						closable: true, 
						width: $('#mainPanle').width() - 10, 
						height: $('#mainPanle').height() - 26
					}); 
				} else { 
					$('#tabs').tabs('select', subtitle); 
				}
				
				tabClose();
				tabCloseEven();
			} 
			
 
			function createFrame(url) { 
				var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>'; 
				return s; 
			} 
 
 
			function tabClose() { 
				$(".tabs-inner").dblclick(function () { 
					var subtitle = $(this).children("span").text(); 
					$('#tabs').tabs('close', subtitle); 
				}) 
 
				$(".tabs-inner").bind('contextmenu', function (e) { 
					$('#mm').menu('show', { 
						left: e.pageX, 
						top: e.pageY
					}); 
					var subtitle = $(this).children("span").text(); 
					$('#mm').data("currtab", subtitle); 
					return false; 
				}); 
          		 } 
 
			function tabCloseEven() { 
				$('#mm-tabclose').click(function () { 
					var currtab_title = $('#mm').data("currtab"); 
					$('#tabs').tabs('close', currtab_title); 
				}) 
				$('#mm-tabcloseall').click(function () { 
					$('.tabs-inner span').each(function (i, n) { 
						var t = $(n).text(); 
						$('#tabs').tabs('close', t); 
					}); 
				}); 
 
				$('#mm-tabcloseother').click(function () { 
					var currtab_title = $('#mm').data("currtab"); 
					$('.tabs-inner span').each(function (i, n) { 
						var t = $(n).text(); 
						if (t != currtab_title) 
						$('#tabs').tabs('close', t); 
					}); 
				}); 
				$('#mm-tabcloseright').click(function () { 
					var nextall = $('.tabs-selected').nextAll(); 
					if (nextall.length == 0) {
						alert('后边没有啦~~'); 
 						return false; 
					} 
					nextall.each(function (i, n) { 
						var t = $('a:eq(0) span', $(n)).text(); 
						$('#tabs').tabs('close', t); 
					}); 
					return false; 
				}); 
				$('#mm-tabcloseleft').click(function () { 
					var prevall = $('.tabs-selected').prevAll(); 
					if (prevall.length == 0) { 
						alert('到头了，前边没有啦~~'); 
						return false; 
					} 
					prevall.each(function (i, n) { 
						var t = $('a:eq(0) span', $(n)).text(); 
						$('#tabs').tabs('close', t); 
					}); 
					return false; 
				}); 
				$("#mm-exit").click(function () { 
					$('#mm').menu('hide'); 
				 }) 
			}
		});