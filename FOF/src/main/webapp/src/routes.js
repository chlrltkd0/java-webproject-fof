import ImgCarousel from './components/imgCarousel.vue'
import BBS from './components/BBS.vue'
import WriteBoard from './components/writeboard.vue'
import Board from './components/board.vue'

export default [
	{ path: '/', component: ImgCarousel},
	{ path: '/bbs', component: BBS},
	{ path: '/writeboard', component: WriteBoard},
	{ path: '/board', component: Board}
]
