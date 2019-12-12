

public class Chinese_Phrasing 
{
	private String metadata = "電商必學 FB 行銷術！設定 AI「廣播」訊息，促進互動還能提高回購率, 【我們為什麼挑選這篇文章】想要成為一個成功的行銷達人或是經營電商希望進一步提高銷量，這一切都根基於如何成功與社群建立良好且密切的關係。 這次 Facebook 推出了最新功能「廣播 (Broadcast)」，讓行銷訊息用 AI 客製化地送到顧客私人訊息中，達到前所未有的行銷成效。這篇文章由國內最大的人工智慧聊天機器人平台 HIGH5.ai 創辦人 Nelson Chu (朱浩賢） 撰寫，分享 Facebook 新功能將如何創造客服和行銷新契機。（責任編輯：劉庭瑋） Facebook 這個月推出的最新功能「廣播 (Broadcast)」已經處於公測階段，未來將大幅影響電子商務和網路行銷的操作趨勢！ 現在的粉絲專業大多透過「發佈貼文 (post)」來和顧客溝通，然而日益低迷的觸及迫使店家不斷投入廣告預算，顧客對於太過於制式的廣告類型貼文也愈來愈不買單。於是，一部分網路行銷的操作焦點開始投注在「對話式行銷」上，希望透過對話能給予顧客更客製化、貼心的服務，訊息也比貼文更不容易被忽略，因此 強化顧客關係管理、達成更高的購買轉換率。 然而，過去在 messenger 上，非媒體類型的一般粉絲專頁若要私下推播訊息給顧客，必須仰賴手動與顧客一對一的對話，也不能向沒有對話過的顧客主動發送訊息。現在，有了「廣播 (Broadcast)」的功能， 搭配「私下回覆 (Private Replies)」功能，就大幅提升利用 messenger 開始對話式行銷的可能！ 訊息精準傳遞，加上可供使用的數據資料 「廣播 (Broadcast)」的功能允許店家利用「曾經對話過的顧客」製成群組，主動將訊息同時私訊推播給大量的顧客，並且會得到「有推播成功」的顧客數量相關數據，供店家分析。 那麼，要怎麼快速、大量的累積「曾經對話過的顧客」呢？或許大家都看過下面這些類型的貼文： 一、服飾廣告的貼文只貼出穿搭方式和商品介紹，若顧客想看知道價錢，就要在貼文下 +1 留言。 二、字體公司運用聊天機器人創意行銷，三天湧入 30,000 多 則留言郵遞區號，顧客也透過 messenger 收到了手寫情書。 這種利用貼文下方留言， 店家就能透過 messenger 回覆顧客有趣內容的方式，稱為「私下回覆 (Private Replies)」。不僅提高了自然觸及率，轉換成收入或曝光 ，更重要的是它可以在無形中大量的累積「曾經對話過的顧客」，使得可以「廣播 (Broadcast)」的對象變得更多！ Messenger「廣播」如何收費？ 至於實際使用「廣播 (Broadcast)」功能，Facebook 要不要收費呢？ 目前 Facebook 將粉絲專頁區分為娛樂與媒體業（例如：紐約時報、蘋果日報、JUKSY 街星等等）和一般的企業兩種類型。 若是娛樂與媒體業的粉絲專頁「廣播」新聞報導，不需要付費就能「廣播」。但會隨著顧客的喜好或當天收到的「新聞廣播」數量的限制。 然而，不論是娛樂與媒體業或是一般的企業的粉絲專頁，只要「廣播」的訊息內容涉及行銷、銷售，就需要 像推播 Facebook 廣告一樣採競價模式，受到預算高低或客群設定的精準程度影響。Facebook 也會控制顧客在一天之內收到的廣告訊息數量，避免顧客的收件夾滿滿都是廣告。 快來嘗試 Facebook 這些特別又有趣的功能，搭上對話式行銷的浪潮吧！   （本文經 Nelson Chu   授權轉載，並同意 TechOrange 編寫導讀與修訂標題，原文標題為 〈在 Messenger 上「廣播」？Facebook 新功能再次顛覆對話式行銷！ 〉。首圖取自 flickr） 延伸閱讀 【影音】臉書廣告貴翻天怎麼辦？awoo 阿物揭秘 SEO 最強成長駭客行銷術 Facebook 新功能秘密測試中：部分網站流量暴跌 75%，臉書高管還要出來拍拍安慰大家 臉書滑來滑去都好無聊！那你該試試最新「動態探索」功能，一秒讓你知道最夯的貼文都是啥 臉書老闆娘普莉希拉・陳不為人知的 8 個小故事：13 歲立志上哈佛、廁所排隊遇上真愛馬克！ 從哈佛宿舍到全球 20 億用戶：「別驕傲得不屑抄襲」讓祖克柏走上社群王者之路";
	
	public Chinese_Phrasing()
	{
		String temp[];
		
		int tag_1_index;
		int tag_2_index;
		String tag_1 = ",";
		String tag_2 = "，";
		int count_tag_1 = 0;
		int count_tag_2 = 0;
		String final_tag;
		
		// ------------------------------------------------------------------------
		// Method 1
		tag_1_index = metadata.indexOf(tag_1);
		tag_2_index = metadata.indexOf(tag_2);		
		if(tag_1_index > tag_2_index) {
			final_tag = tag_1;
		}else {
			final_tag = tag_2;
		}		
//		System.out.println(tag_1_index+"	"+tag_2_index+"	"+final_tag);
		// ------------------------------------------------------------------------
		// Method 2
		String str_chat;		
		
		for(int i=0; i<metadata.length(); i++)
		{
			str_chat = String.valueOf(metadata.charAt(i));
			if(str_chat.equalsIgnoreCase(tag_1)) {
				count_tag_1 ++;
			}
		}
		
		for(int i=0; i<metadata.length(); i++)
		{
			str_chat = String.valueOf(metadata.charAt(i));
			if(str_chat.equalsIgnoreCase(tag_2)) {
				count_tag_2 ++;
			}
		}
		
		if(count_tag_1 > count_tag_2) {
			final_tag = tag_1;
		}else {
			final_tag = tag_2;
		}
		System.out.println(count_tag_1+"	"+count_tag_2+"	"+final_tag);
		
		// ------------------------------------------------------------------------
		
		temp = metadata.split(final_tag);
		System.out.println(temp.length);
		for(int i=0; i<temp.length; i++)
		{
			System.out.println(temp[i]);
		}
	}
	
	public static void main(String[] args)
	{
		Chinese_Phrasing cp = new Chinese_Phrasing();
	}
	
}
