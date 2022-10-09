function displayNextImage() {
    if(document.getElementById('img').src == 'https://www.mathsisfun.com/data/images/graph-gen.svg') {
        document.getElementById('img').src = 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Polynomial_of_degree_three.svg/1200px-Polynomial_of_degree_three.svg.png'
    } else if(document.getElementById('img').src == 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Polynomial_of_degree_three.svg/1200px-Polynomial_of_degree_three.svg.png'){
        document.getElementById('img').src = 'https://s3-us-west-2.amazonaws.com/courses-images/wp-content/uploads/sites/2043/2017/07/01214432/IMG_Econ_01_011.png'
    } else {
        document.getElementById('img').src = 'https://www.mathsisfun.com/data/images/graph-gen.svg'
    }
}

movingblock = document.getElementsByClassName('graphs')
movingblock[0].addEventListener("animationiteration", displayNextImage);