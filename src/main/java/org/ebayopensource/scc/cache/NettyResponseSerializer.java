/*******************************************************************************
 * Copyright (c) 2016 eBay Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.ebayopensource.scc.cache;

import java.util.List;
import java.util.Map.Entry;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.LastHttpContent;

public class NettyResponseSerializer extends
		BaseResponseSerializer<FullHttpResponse> {

	@Override
	protected ByteBuf[] getContent(Object obj) {
		return new ByteBuf[] { ((HttpContent) obj).content() };
	}

	@Override
	protected List<Entry<String, String>> getTrailingHeaders(Object obj) {
		return ((LastHttpContent) obj).trailingHeaders().entries();
	}

	@Override
	protected HttpResponse getHttpResponse(Object obj) {
		return (HttpResponse) obj;
	}

	@Override
	public Class<? extends FullHttpResponse> getType() {
		return FullHttpResponse.class;
	}
}
