const progressCircle = document.querySelector(".autoplay-progress svg");
const progressContent = document.querySelector(".autoplay-progress span");
const topSwiper = new Swiper(".topSwiper", {
    spaceBetween: 30,
    // loop: true,
    centeredSlides: true,
    autoplay: {
        delay: 2500,
        disableOnInteraction: false
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev"
    },
    on: {
        autoplayTimeLeft(s, time, progress) {
            progressCircle.style.setProperty("--progress", 1 - progress);
            progressContent.textContent = `${Math.ceil(time / 1000)}s`;
        }
    }
});

const bottomSwiper = new Swiper(".bottomSwiper", {
    slidesPerView: 3,
    spaceBetween: 30,
    grabCursor: true,
    pagination: {
        clickable: true,
    },
});

const swiper = new Swiper(".game-detail-swiper", {
    effect: "cards",
    grabCursor: true,
    initialSlide: 2,
    loop: true,
    rotate: true,
    mousewheel: {
        invert: false,
    },
});