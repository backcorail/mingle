document.addEventListener("DOMContentLoaded", () => {
	// 체크 박스 추가
	const container = document.querySelector(".container");

	const values = ["제주", "서울", "부산", "인천"]; // 각 체크박스의 value 값 설정
	const values2 = ["Jeju", "Seoul", "Busan", "Incheon"]; // 각 체크박스의 value 값 설정

	for (let i = 1; i <= values.length; i++) {
		// 레이블 요소 생성
		const label = document.createElement("label");
		label.setAttribute("for", `checkbox-${i}`);

		// 체크박스 생성
		const checkbox = document.createElement("input");
		checkbox.type = "checkbox";
		checkbox.id = `checkbox-${i}`;
		checkbox.name = "checkbox";
		checkbox.value = values2[i - 1]; // 각 체크박스에 value 값 할당

		// 텍스트 추가
		const labelText = document.createTextNode(`${values[i - 1]}`);

		// 요소 구성
		label.appendChild(checkbox);
		label.appendChild(labelText);
		container.appendChild(label);
	}

	// checkbox 중복 체크 방지 및 색상 설정
	const checkboxes = document.querySelectorAll('input[type="checkbox"][name="checkbox"]');

	checkboxes.forEach(checkbox => {
		checkbox.addEventListener('change', () => {
			if (checkbox.checked) {
				// 모든 체크박스에 연결된 요소들의 색상을 흰색으로 초기화
				checkboxes.forEach(cb => {
					const label = document.querySelector(`label[for="${cb.id}"]`);
					const mapElement = label ? document.querySelector(`.${label.textContent.trim()}`) : null;

					if (mapElement) {
						mapElement.style.color = 'white';
						mapElement.style.textShadow = 'none'; // 기존 text-shadow 제거
					}

					// 클릭된 체크박스 외에 다른 모든 체크박스의 체크를 해제
					if (cb !== checkbox) {
						cb.checked = false;
					}
				});

				// 현재 선택된 값의 요소 색상 및 text-shadow를 랜덤 색상으로 변경
				const label = document.querySelector(`label[for="${checkbox.id}"]`);
				const selectedText = label ? label.textContent.trim() : "";
				const selectedMap = document.querySelector(`.${selectedText}`);

				if (selectedMap) {
					selectedMap.style.color = getRandomColor();
					selectedMap.style.textShadow = `3px 3px 6px grey`; // 랜덤 색상 text-shadow 설정
				}
			}
		});
	});

});

// 랜덤 색상 생성 함수 (RGB 값 사용)
function getRandomColor() {
	const r = Math.floor(Math.random() * 256);
	const g = Math.floor(Math.random() * 256);
	const b = Math.floor(Math.random() * 256);
	return `rgb(${r}, ${g}, ${b})`;
}

// 요소 선택 시, 아이디 선택자(#) 추가
const bg = document.querySelector(".background");
const bg2 = document.querySelector(".background2");
const nBtn = document.querySelector("#cody_nextBtn");
const pBtn = document.querySelector("#cody_prevBtn");
const sBtn = document.querySelector("#cody_sendBtn");

function btnClick(n) {
	if (n == 1) {
		// 페이지 변경
		bg.style.display = "block";
		bg2.style.display = "none";
		// next 활성화 및 send 비활성화
		nBtn.style.display = "block";
		sBtn.style.display = "none";
		// prev 비활성화
		pBtn.style.pointerEvents = "none";
		pBtn.style.opacity = "0.5";
	}
	if (n == 2) {
		if (sBtn.style.display == "none") {
			// next 비활성화 및 send 활성화
			nBtn.style.display = "none";
			sBtn.style.display = "block";
			// prev 활성화
			pBtn.style.pointerEvents = "auto";
			pBtn.style.opacity = "1";
			// 페이지 변경
			bg.style.display = "none";
			bg2.style.display = "block";
		}
	}
	if (n == 3) {
		if (validateForm()) {
			document.getElementById("cody_form").submit();  // 폼 제출
		} else {
			return false;
		}
	}
}

//유효성 검사(두가지 종류(region, concept)의 checkbox선택 여부 확인)
function validateForm() {
	const cb = document.querySelector('input[name="checkbox"]:checked');
	const cc = document.querySelector('input[name="concept"]:checked');
	if (!(cb && cc)) {
		alert("Region과 Concept 둘다 선택해 주세요.");
		return false;
	}

	// getWeather의 결과를 then으로 처리
	getWeather(cb.value).then((gw) => {
		const data = {
			weatherKR: gw.weather[0].description,
			weatherEN: gw.weather[0].main,
			iconURL: `https://openweathermap.org/img/wn/${gw.weather[0].icon}@2x.png`,
			region: cb.value,
			concept: cc.value
		};
		console.log(data);
		// POST 요청을 보내는 함수
		fetch("${pageContext.request.contextPath}/cody/board", {
			method: "POST",
			headers: {
				"Content-Type": "application/json", // JSON 형식의 데이터를 보낼 경우
			},
			body: JSON.stringify(data), // 객체를 JSON 문자열로 변환하여 전송
		})
			.then(response => response.json()) // JSON 응답을 받음
			.then(result => {
				console.log("Server response:", result); // 응답 데이터 출력
			})
			.catch(error => {
				console.error("Error:", error); // 에러 처리
			});
	});
	return false;
}

// 날씨 관련
const getWeather = (region) => {
	return fetch(
		`https://api.openweathermap.org/data/2.5/weather?q=${region}&lang=kr&appid=56d8abc511eaad05c4aa42b661ae70e3`
	)
		.then((response) => {
			return response.json();
		});
};
