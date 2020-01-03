<template> 
	<div>
	<table class="table"><tr>
	<th>No.</th><th>아이디</th><th>비번</th><th>이름</th><th>생년월일</th>
	<th>성별</th><th>학년</th><th>반</th><th>점수</th><th>역할</th>
	</tr>
	<tr v-for="(j) of paginatedData" :key="j.id">
	<td>{{j.personid}}</td>
	<td>{{j.userid}}</td>
	<td>{{j.passwd}}</td>
	<td>{{j.name}}</td>
	<td>{{j.birthday}}</td>
	<td>{{j.gender}}</td>
	<td>{{j.hak}}</td>
	<td>{{j.ban}}</td>
	<td>{{j.score}}</td>
	<td>{{j.role}}</td>
	</tr>
	</table>
	
	<div class="btn-cover" >
      <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
        이전
      </button>

      <span class="page-count">{{ pageNum+1 }} / {{pageCount}} </span>
      <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
        다음
      </button>
	</div>
	
</div>	
</template>
<script>
export default{
	name: 'pagination',
	data(){
		return {
			pageNum: 0
		}
	},
	props: {
		listArray: {
			type: Array,
			required: true
		},
		pageSize : {
			type: Number,
			required: true,
			default: 5
		}
	},
	methods : {
		prevPage(){this.pageNum -= 1},
		nextPage(){this.pageNum += 1}
	},
	computed: {
		pageCount(){
			let listLeng = this.listArray.length,
			listSize = this.pageSize,
			page = Math.floor(listLeng / listSize)
			if(listLeng % listSize > 0) page += 1
			return page
		},
		paginatedData(){
			const start = this.pageNum * this.pageSize,
						end = start + this.pageSize
			return this.listArray.slice(start, end)
		}
	}
}
</script>
<style scoped>
.table {
  width: 100%;
  border-collapse: collapse;
}
.table th {
  font-size: 1.2rem;
}
.table tr {
  height: 2rem;
  text-align: center;
  border-bottom: 1px solid #505050;
}
.table tr:first-of-type {
  border-top: 2px solid #404040;
}
.table tr td {
  padding: 1rem 0;
  font-size: 1.1rem;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
  border: 1px solid black;
  margin-right: 10px;
  margin-left: 10px;
}
</style>