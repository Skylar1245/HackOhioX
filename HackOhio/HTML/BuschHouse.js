//changes the image on the scroll block
function displayNextImage() {
	//check which image is currently displayed
	if(document.getElementById('img').src =='https://raw.githubusercontent.com/Skylar1245/HackOhioX/4dc36a2c0a5c4e76943068692cc3234da969e14b/HackOhio/graphs/BuschPlotPerPerson.png') {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/BuschPlotAnnual.png';
	} else if(document.getElementById('img').src =='https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/BuschPlotAnnual.png') {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/BuschPlotCategories.png';
	} else {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/4dc36a2c0a5c4e76943068692cc3234da969e14b/HackOhio/graphs/BuschPlotPerPerson.png';
	}
}

//gets an array of all the elements within the class og graphs
movingblock = document.getElementsByClassName('graphs');

//waits until the animation has finished an iteration to switch the image
movingblock[0].addEventListener("animationiteration", displayNextImage);
