<#--
/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->
<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if hasFieldErrors>
<#if (parameters.dynamicAttributes?? && parameters.dynamicAttributes?size > 0)><#rt/>
<#assign aKeys = parameters.dynamicAttributes.keySet()><#rt/>
<#list aKeys as aKey><#rt/>
  <#assign keyValue = parameters.dynamicAttributes.get(aKey)/>
   <#assign value = keyValue?string/>
	<#if aKey="placeholder"><#rt/>
	<#list fieldErrors[parameters.name] as error>
		placeholder="${error?html}"<#rt/>
	</#list>
	</#if>
	${aKey}="${value?html}"<#rt/>
</#list><#rt/>
</#if><#rt/>
<#else>
<#if (parameters.dynamicAttributes?? && parameters.dynamicAttributes?size > 0)><#rt/>
<#assign aKeys = parameters.dynamicAttributes.keySet()><#rt/>
<#list aKeys as aKey><#rt/>
  <#assign keyValue = parameters.dynamicAttributes.get(aKey)/>
   <#assign value = keyValue?string/>
	${aKey}="${value?html}"<#rt/>
</#list><#rt/>
</#if><#rt/>
</#if>
