<template> 
	<div>학생들 목록 
	<pagination :list-array="pageArray"/>
	
</div>	
</template>
<script>
import axios from 'axios'
import Pagination from '@/components/cmm/Pagination.vue'
export default{
	data(){
		return {
			ctx: this.$store.state.common.context,
			pageArray: []
		}
	},
	components:{
		Pagination
	},
	created(){
		axios
		.get(`${this.ctx}/students`)
		.then(res =>{
			/* let arr = []
			for(let i = 1; i< res.data.length/5; i++){
				arr.push(i)
			}
			
			this.pages = arr
			this.list = res.data.slice(0,5) */
			this.pageArray = res.data
		})
		.catch(e=>{
			alert('AXIOS FAIL'+e)
		})
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