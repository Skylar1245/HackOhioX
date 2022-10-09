function displayNextImage() {
	if(document.getElementById('img').src =='https://raw.githubusercontent.com/Skylar1245/HackOhioX/4dc36a2c0a5c4e76943068692cc3234da969e14b/HackOhio/graphs/BuschPlotPerPerson.png') {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/BuschPlotAnnual.png';
	} else if(document.getElementById('img').src =='https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/BuschPlotAnnual.png') {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/BuschPlotCategories.png';
	} else {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/4dc36a2c0a5c4e76943068692cc3234da969e14b/HackOhio/graphs/BuschPlotPerPerson.png';
	}
}

movingblock = document.getElementsByClassName('graphs');
movingblock[0].addEventListener("animationiteration", displayNextImage);
