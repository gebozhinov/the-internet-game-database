const swiper = new Swiper(".mySwiper", {
    direction: "vertical",
    slidesPerView: 1,
    spaceBetween: 0,
    mousewheel: false,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
});