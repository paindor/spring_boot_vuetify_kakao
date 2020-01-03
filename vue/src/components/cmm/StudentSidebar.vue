<template>
	<div>
		<ul class="menu">
			<li v-for="i of sidebars" :key="i.menu">
				<router-link :to="i.link">{{i.menu}}</router-link>
			</li>
		</ul>
	</div>
</template>
<script>
export default{
	data(){
		return {
			sidebars : [
				{menu:"내정보보기",link:"/write"},
				{menu:"비밀번호변경",link:"/write"},
				{menu:"글쓰기",link:"/write"},
				{menu:"목록",link:"/list"},
				{menu:"글수정",link:"/update"},
				{menu:"글삭제",link:"/remove"},
				{menu:"검색",link:"/search"}
			]
		}
	}
}
</script>
<style scoped></style>