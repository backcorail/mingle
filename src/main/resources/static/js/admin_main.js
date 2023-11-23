document.addEventListener('DOMContentLoaded', function() {
    // 모든 메뉴 아이템에 대한 참조를 얻습니다.
    var allMenuItems = document.querySelectorAll('.sidebar-menu li');
    var subMenuLinks = document.querySelectorAll('.sidebar-menu .submenu a');

    // 메뉴 아이템 클릭 이벤트 리스너를 설정합니다.
    allMenuItems.forEach(function(item) {
        item.addEventListener('click', function() {
            // 'active' 클래스를 모든 메뉴 아이템에서 제거합니다.
            allMenuItems.forEach(function(i) {
                i.classList.remove('active');
            });

            // 클릭된 메뉴 아이템에 'active' 클래스를 추가합니다.
            this.classList.add('active');
        });
    });

    // 하위 메뉴 링크 클릭 이벤트 리스너를 설정합니다.
    subMenuLinks.forEach(function(link) {
        link.addEventListener('click', function(e) {
            // 버블링을 방지하여 상위 메뉴의 이벤트가 트리거되지 않도록 합니다.
            e.stopPropagation();

            // 'active' 클래스를 모든 메뉴 아이템에서 제거합니다.
            allMenuItems.forEach(function(i) {
                i.classList.remove('active');
            });

            // 클릭된 하위 메뉴 아이템과 그것의 상위 메뉴 아이템에 'active' 클래스를 추가합니다.
            this.classList.add('active');
            var parentMenuItem = this.closest('.sidebar-menu > li');
            if (parentMenuItem) {
                parentMenuItem.classList.add('active');
            }
        });
    });
});
