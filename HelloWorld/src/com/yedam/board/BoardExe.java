package com.yedam.board;
/*
 * 1.등록 2.목록
 */
public class BoardExe {
	private Board[] storage; // 필드 선언.
	
	public BoardExe() {  // 초기화.
		storage = new Board[10];
		storage[1] = new Board(2, "자바는 재밌어", "열심히 합시다", "user01", new Date());
		storage[2] = new Board(3, "오늘은 화요일", "3일이나 남았네", "user02", new Date());
		storage[9] = new Board(1, "프로그래밍", "뭐먹지", "user03", new Date());
	}
	
	// 게시글 등록.
	public boolean insertBoard(Board board) {
		for(int i=0; i<storage.length; i++) {
			if(storage[i] == null) {
			   storage[i] = board;
			   return true;
			}
		}
		return false;
	}
	
	// 목록.
	public Board[] boardList() {
		// 정렬.
		for(int j = 0; j < storage.length - 1; j++) {
     		for(int i = 0; i < storage.length - 1; i++) {
     			// 뒷자리가 null 이면 nothing
     			if(storage[i + 1] == null) {
     				continue;
     			}
     		Board temp = null;
     		if(storage[i]==null //
     				|| storage[i].getBoardNo() > storage[i + 1].getBoardNo()) {
     			//위치 변경 [i] <--> [i+1]
//     		if(storage[i].getBoardNo() > storage[i + 1].getBoardNo());
     		  temp = storage[i];
     		  storage[i] = storage[i + 1];
     		  storage[i + 1] = temp;
     	 }
     	}		
	  } // end of 1st for
		return storage;
	} // end of 2nd for
	
	// 글번호 가져오는 메소드.
	// null이 아닌 카운트에 + 1 한 값을 반환. (X)
	// boardNo의 max값에 +1 한 값을 반환. (O)
	public int getNextNo() {
		int cnt = 0;
		for(int i=0; i<storage.length; i++) {
			if(storage[i] != null) {
				int bno = storage[i].getBoardNo();
				if (cnt < bno) { // 현재의 max값보다 큰 값일 경우에..
					cnt = bno;
				}
				
//				cnt++;
			}
		}
		return cnt + 1;
	}
	
	// 글삭제기능 => 매개값은 글번호, 반환값은 true/ false , deleteBoard() 메서드이름
	public boolean deleteBoard(int bno) { // 메인 글번호 가져옴 int bno
		for(int i=0; i<storage.length; i++) {
			if(storage[i] != null && storage[i].getBoardNo() == bno) { // 비교해서 삭제
			      storage[i] = null;	// 삭제는 null 대입.
			      return true;
			}
		}
		return false;
	}
	
	// 글수정기능 => 매개값은 글번호+내용+제목, 반환값은 true/ false, updateBoard()
	public boolean updateBoard(Board board) {
		for(int i=0; i<storage.length; i++) {
			if(storage[i] != null
					&& storage[i].getBoardNo() == board.getBoardNo()) { 
			   storage[i].setTitle(board.getTitle());
			   storage[i].setContent(board.getcontent());
			      return true;
			}
		}
		return false;
	}
	
	
	// 삭제, 수정 권한있는지 체크 => 매개값은 글번호 , 작성자, 반환값은 true/ false
	// checkResponsibilty() 메서드
	public boolean checkResponsibilty(int bno, String writer) { //
		for(int i=0; i<storage.length; i++) {
			if(storage[i] != null) {
				if (storage[i].getBoardNo() == bno && storage[i].getwriter().equals(writer)) { // 비교
			        return true;
				}
			}
		}
		return false;
	}
}
